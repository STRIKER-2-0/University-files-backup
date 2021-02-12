
#include "stm32f4xx.h"
#include "stm32f4xx_gpio.h"
#include "stm32f4xx_rcc.h"

void Delay(uint32_t nCount){
	while(nCount--);
}

enum State{
	RS,
	LED3,
	LED4,
	LED5,
	LED6
};

int main(void) {
	GPIO_InitTypeDef gpioConf;
	static enum State state = RS;

	// инициализация входа, подключенного к кнопке
	RCC_AHB1PeriphClockCmd(RCC_AHB1Periph_GPIOA, ENABLE);
	gpioConf.GPIO_Pin = GPIO_Pin_0;
	gpioConf.GPIO_Mode = GPIO_Mode_IN;
	GPIO_Init(GPIOA, &gpioConf);


	// инициализация входа, подключенного к светодиоду
	RCC_AHB1PeriphClockCmd(RCC_AHB1Periph_GPIOD, ENABLE);
	gpioConf.GPIO_Pin = GPIO_Pin_12 | GPIO_Pin_13 | GPIO_Pin_14 | GPIO_Pin_15;
	gpioConf.GPIO_Mode = GPIO_Mode_OUT;
	gpioConf.GPIO_Speed = GPIO_Speed_100MHz;
	gpioConf.GPIO_OType = GPIO_OType_PP;
	gpioConf.GPIO_PuPd = GPIO_PuPd_NOPULL;
	GPIO_Init(GPIOD, &gpioConf);

	while(1) {
		if(GPIO_ReadInputDataBit(GPIOA, GPIO_Pin_0) == 0) {
			switch(state){
			case RS:
				state++;
				if(GPIO_ReadOutputDataBit(GPIOD, GPIO_Pin_12))
					GPIO_ResetBits(GPIOD, GPIO_Pin_12);
				if(GPIO_ReadOutputDataBit(GPIOD, GPIO_Pin_13))
					GPIO_ResetBits(GPIOD, GPIO_Pin_13);
				if(GPIO_ReadOutputDataBit(GPIOD, GPIO_Pin_14))
					GPIO_ResetBits(GPIOD, GPIO_Pin_14);
				if(GPIO_ReadOutputDataBit(GPIOD, GPIO_Pin_15))
					GPIO_ResetBits(GPIOD, GPIO_Pin_15);
				break;
			case LED4:
				if(!GPIO_ReadOutputDataBit(GPIOD, GPIO_Pin_12))
					GPIO_SetBits(GPIOD, GPIO_Pin_12);
				state++;
				break;
			case LED3:
				if(!GPIO_ReadOutputDataBit(GPIOD, GPIO_Pin_13))
					GPIO_SetBits(GPIOD, GPIO_Pin_13);
				state++;
				break;
			case LED5:
				if(!GPIO_ReadOutputDataBit(GPIOD, GPIO_Pin_14))
					GPIO_SetBits(GPIOD, GPIO_Pin_14);
				state++;
				break;
			case LED6:
				if(!GPIO_ReadOutputDataBit(GPIOD, GPIO_Pin_15))
					GPIO_SetBits(GPIOD, GPIO_Pin_15);
				state++;
				break;
			default:
				state = RS;
				break;
			}
			while(GPIO_ReadInputDataBit(GPIOA, GPIO_Pin_0)==0)
				Delay(1000);
			Delay(5000);
		}
	}

}



