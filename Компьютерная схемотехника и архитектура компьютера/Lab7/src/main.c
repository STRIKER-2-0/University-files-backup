#include "stm32f4xx.h"
#include "stm32f4xx_gpio.h"
#include "stm32f4xx_rcc.h"
#include "stm32f4xx_tim.h"
#include "stm32f4xx_adc.h"
#include "stm32f4xx_usart.h"
#include "misc.h"
#include "init.h"

enum State {
	LED4,
	LED3,
	LED5,
	LED6
};

enum Command {
	STOP,
	RUN
};

static enum State state = LED4;
static enum Command command = RUN;
static uint32_t counter = 0;
unsigned int bin_code = 0;
const uint32_t KOEFF = 65536 / 4095;    //max brightness / max adc value

u16 readADC1(u8 channel) {
	ADC_RegularChannelConfig(ADC1, channel, 1, ADC_SampleTime_3Cycles);
	ADC_SoftwareStartConv(ADC1);
	while (ADC_GetFlagStatus(ADC1, ADC_FLAG_EOC) == RESET);
	return ADC_GetConversionValue(ADC1);
}

void logic(uint32_t brightness) {
	switch (state) {
	case LED4:
		TIM4->CCR1 = brightness;
		TIM4->CCR4 = 0;
		break;
	case LED3:
		TIM4->CCR2 = brightness;
		TIM4->CCR1 = 0;
		break;
	case LED5:
		TIM4->CCR3 = brightness;
		TIM4->CCR2 = 0;
		break;
	case LED6:
		TIM4->CCR4 = brightness;
		TIM4->CCR3 = 0;
		break;
	default:
		state = LED4;
	}
}

int main(void) {
	init();

	while (1) {
		//double voltage = bin_code * 2.96 / 0xfff;
		logic(bin_code * KOEFF);
	}
}

void TIM2_IRQHandler(void) {
	if (TIM_GetITStatus(TIM2, TIM_IT_Update) != RESET) {
		TIM_ClearITPendingBit(TIM2, TIM_IT_Update);

		if(command == RUN){
			counter++;
			if (counter == 10) {
				counter = 0;
				state++;
			}
		}
		bin_code = readADC1(ADC_Channel_1);
	}
}

void USART1_IRQHandler(void){
	if(USART_GetITStatus(USART1, USART_IT_RXNE) != RESET){
		USART_ClearITPendingBit(USART1, USART_IT_RXNE);
		uint8_t data = USART_ReceiveData(USART1);
		if(data == (uint8_t)'s')
			command = STOP;
		else if(data == (uint8_t)'r')
			command = RUN;

		while (USART_GetFlagStatus(USART1, USART_FLAG_TC) == RESET);
		USART_DMACmd(USART1, USART_DMAReq_Tx, ENABLE);
		while (USART_GetFlagStatus(USART1, USART_FLAG_TC) == RESET);
		USART_DMACmd(USART1, USART_DMAReq_Tx, DISABLE);
//		while (USART_GetFlagStatus(USART1, USART_FLAG_TC) == RESET);
//		USART_SendData(USART1, (uint8_t)'k');
//		while (USART_GetFlagStatus(USART1, USART_FLAG_TC) == RESET);
//		USART_SendData(USART1, (uint8_t)'\n');
	}
}


