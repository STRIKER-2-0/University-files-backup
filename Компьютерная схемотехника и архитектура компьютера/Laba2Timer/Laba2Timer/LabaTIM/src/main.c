
#include "stm32f4xx.h"
#include "stm32f4xx_gpio.h"
#include "stm32f4xx_rcc.h"
#include "stm32f4xx_tim.h"
#include "misc.h"

void INTTIM_Config(void);

void GPIO_Config(void);
static void PWM_TimerInit(void);

static uint8_t count_tim = 0;
static int brightness = 0;

int main(void) {


    GPIO_Config();
    INTTIM_Config();
    PWM_TimerInit();

    while (1) {

    	switch(mode){
    	case 1:
    		brightness++;

    		TIM4->CCR1 = 0;
    		TIM4->CCR3 = 333 - (brightness + 0) % 333;

    		for(i=0;i < 10000; ++i);
    		for(i=0;i < 10000; ++i);

    		break;
    	case 2:
    	}
    }

}

void GPIO_Config(void) {
    GPIO_InitTypeDef gpioConf;
    GPIO_InitTypeDef gpio_init;

    // инициализация входа, подключенного к кнопке
    RCC_AHB1PeriphClockCmd(RCC_AHB1Periph_GPIOA, ENABLE);
    gpioConf.GPIO_Pin = GPIO_Pin_0;
    gpioConf.GPIO_Mode = GPIO_Mode_IN;
    GPIO_Init(GPIOA, &gpioConf);

    //	инициализация входа, подключенного к светодиоду по прерыванию таймера 2
    RCC_AHB1PeriphClockCmd(RCC_AHB1Periph_GPIOD, ENABLE);
    gpioConf.GPIO_Pin = GPIO_Pin_12 ;
    gpioConf.GPIO_Mode = GPIO_Mode_OUT;
    gpioConf.GPIO_Speed = GPIO_Speed_100MHz;
    gpioConf.GPIO_OType = GPIO_OType_PP;
    gpioConf.GPIO_PuPd = GPIO_PuPd_NOPULL;
    GPIO_Init(GPIOD, &gpioConf);

    //инициализация входа, подключенного к светодиодам по управлению шимом
    gpio_init.GPIO_Pin =  GPIO_Pin_13 | GPIO_Pin_14 | GPIO_Pin_15;
    gpio_init.GPIO_Mode = GPIO_Mode_AF;
    gpio_init.GPIO_Speed = GPIO_Speed_100MHz;
    gpio_init.GPIO_OType = GPIO_OType_PP;
    gpio_init.GPIO_PuPd = GPIO_PuPd_UP;
    GPIO_Init(GPIOD, &gpio_init);

   // GPIO_PinAFConfig(GPIOD, GPIO_PinSource12, GPIO_AF_TIM4);
    GPIO_PinAFConfig(GPIOD, GPIO_PinSource13, GPIO_AF_TIM4);
    GPIO_PinAFConfig(GPIOD, GPIO_PinSource14, GPIO_AF_TIM4);
    GPIO_PinAFConfig(GPIOD, GPIO_PinSource15, GPIO_AF_TIM4);

}

void INTTIM_Config(void) {
    NVIC_InitTypeDef nvic_struct;
    nvic_struct.NVIC_IRQChannel = TIM2_IRQn;
    nvic_struct.NVIC_IRQChannelPreemptionPriority = 0;
    nvic_struct.NVIC_IRQChannelSubPriority = 1;
    nvic_struct.NVIC_IRQChannelCmd = ENABLE;
    NVIC_Init(&nvic_struct);

    TIM_TimeBaseInitTypeDef tim_struct;
    RCC_APB1PeriphClockCmd(RCC_APB1Periph_TIM2, ENABLE);
    tim_struct.TIM_Period = 5000 - 1;
    tim_struct.TIM_Prescaler = 4200 - 1;
    tim_struct.TIM_ClockDivision = 0;
    tim_struct.TIM_CounterMode = TIM_CounterMode_Up;
    TIM_TimeBaseInit(TIM2, &tim_struct);

    TIM_ITConfig(TIM2, TIM_IT_Update, ENABLE);
    TIM_Cmd(TIM2, ENABLE);
}


void TIM2_IRQHandler(void) {
    if (TIM_GetITStatus(TIM2, TIM_IT_Update) != RESET) {
        TIM_ClearITPendingBit(TIM2, TIM_IT_Update);
        count_tim ++;
       // GPIOD->ODR ^= GPIO_Pin_12 | GPIO_Pin_13 | GPIO_Pin_14 | GPIO_Pin_15;
        if(count_tim % 2 )
        {
        	//GPIOD->ODR ^= GPIO_Pin_12;
        	if (GPIO_ReadOutputDataBit(GPIOD, GPIO_Pin_12))
        		GPIO_ResetBits(GPIOD, GPIO_Pin_12);
        	else
        		GPIO_SetBits(GPIOD, GPIO_Pin_12);
        }

        brightness += 100;
		TIM4->CCR3 = 333 - (brightness + 0) % 333;
		TIM4->CCR4 = 333 - (brightness + 166 / 2) % 333;
		//TIM4->CCR1 = 333 - (brightness + 333 / 2) % 333;
		TIM4->CCR2 = 333 - (brightness + 499 / 2) % 333;

    }
}


void PWM_TimerInit(void) {

	TIM_TimeBaseInitTypeDef time_init;
	TIM_OCInitTypeDef oc_init;

	RCC_APB1PeriphClockCmd(RCC_APB1Periph_TIM4, ENABLE);
	uint16_t PrescalerValue = (uint16_t)((SystemCoreClock / 2) / 21000000);

	time_init.TIM_Period = 665;
	time_init.TIM_Prescaler = PrescalerValue;
	time_init.TIM_ClockDivision = 0;
	time_init.TIM_CounterMode = TIM_CounterMode_Up;
	TIM_TimeBaseInit(TIM4, &time_init);

	oc_init.TIM_OCMode = TIM_OCMode_PWM1;
	oc_init.TIM_OutputState = TIM_OutputState_Enable;
	oc_init.TIM_Pulse = 0;
	oc_init.TIM_OCPolarity = TIM_OCPolarity_High;

	//TIM_OC1Init(TIM4, &oc_init);
	//TIM_OC1PreloadConfig(TIM4, TIM_OCPreload_Enable);

	oc_init.TIM_OutputState = TIM_OutputState_Enable; oc_init.TIM_Pulse = 0;
	TIM_OC2Init(TIM4, &oc_init);
	TIM_OC2PreloadConfig(TIM4, TIM_OCPreload_Enable);

	oc_init.TIM_OutputState = TIM_OutputState_Enable; oc_init.TIM_Pulse = 0;
	TIM_OC3Init(TIM4, &oc_init);
	TIM_OC3PreloadConfig(TIM4, TIM_OCPreload_Enable);

	oc_init.TIM_OutputState = TIM_OutputState_Enable; oc_init.TIM_Pulse = 0;
	TIM_OC4Init(TIM4, &oc_init);
	TIM_OC4PreloadConfig(TIM4, TIM_OCPreload_Enable);

	TIM_ARRPreloadConfig(TIM4, ENABLE);
	TIM_Cmd(TIM4, ENABLE);
}



