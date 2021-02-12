#include "stm32f4xx.h"
#include "stm32f4xx_gpio.h"
#include "stm32f4xx_rcc.h"
#include "stm32f4xx_tim.h"
#include "misc.h"

void INTTIM_Config(void);
void GPIO_Config(void);
void timer_pwm_init(void);
void dma_init(void);

enum State{
	LED4,
	LED3,
	LED5,
	LED6,
	ALL
};
static enum State state = LED4;
void logic(){
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
	GPIO_Config();
	INTTIM_Config();
	timer_pwm_init();
	dma_init();

	while(1) {
		logic();
	}
}

void TIM2_IRQHandler(void) {
    if (TIM_GetITStatus(TIM2, TIM_IT_Update) != RESET) {
        TIM_ClearITPendingBit(TIM2, TIM_IT_Update);
        state++;
    }
}

void GPIO_Config(void) {
	// инициализация ножек контроллера
	GPIO_InitTypeDef gpioConf;
	RCC_AHB1PeriphClockCmd(RCC_AHB1Periph_GPIOD, ENABLE);
	gpioConf.GPIO_Pin = GPIO_Pin_12 | GPIO_Pin_13 | GPIO_Pin_14 | GPIO_Pin_15;
	gpioConf.GPIO_Mode = GPIO_Mode_OUT;
	gpioConf.GPIO_Speed = GPIO_Speed_100MHz;
	gpioConf.GPIO_OType = GPIO_OType_PP;
	gpioConf.GPIO_PuPd = GPIO_PuPd_NOPULL;
	GPIO_Init(GPIOD, &gpioConf);
}

void INTTIM_Config(void){
	//инициализация обработки прерываний
	NVIC_InitTypeDef nvic_struct;
	nvic_struct.NVIC_IRQChannel = TIM2_IRQn;
	nvic_struct.NVIC_IRQChannelPreemptionPriority = 0;
	nvic_struct.NVIC_IRQChannelSubPriority = 1;
	nvic_struct.NVIC_IRQChannelCmd = ENABLE;
	NVIC_Init(&nvic_struct);

	TIM_TimeBaseInitTypeDef tim_struct;

	RCC_APB1PeriphClockCmd(RCC_APB1Periph_TIM2, ENABLE);
	tim_struct.TIM_Prescaler = 8400 - 1;
	tim_struct.TIM_Period = 10000 - 1;
	tim_struct.TIM_ClockDivision = 0;
	tim_struct.TIM_CounterMode = TIM_CounterMode_Up;
	TIM_TimeBaseInit(TIM2, &tim_struct);
	TIM_ITConfig(TIM2, TIM_IT_Update, ENABLE);
	TIM_Cmd(TIM2, ENABLE);
}


void timer_pwm_init() {
	TIM_TimeBaseInitTypeDef time_init;
	TIM_OCInitTypeDef oc_init;
	RCC_APB1PeriphClockCmd(RCC_APB1Periph_TIM4, ENABLE);

	uint16_t PrescalerValue = (uint16_t)((SystemCoreClock / 2) / 21000000);

	time_init.TIM_Period = 665;
	time_init.TIM_Prescaler = PrescalerValue;	//5
	time_init.TIM_ClockDivision = 0;
	time_init.TIM_CounterMode = TIM_CounterMode_Up;

	TIM_TimeBaseInit(TIM4, &time_init);

	oc_init.TIM_OCMode = TIM_OCMode_PWM1;
	oc_init.TIM_OutputState = TIM_OutputState_Enable;
	oc_init.TIM_Pulse = 0;
	oc_init.TIM_OCPolarity = TIM_OCPolarity_High;

	TIM_OC1Init(TIM4, &oc_init);
	TIM_OC1PreloadConfig(TIM4, TIM_OCPreload_Enable);

	TIM_ARRPreloadConfig(TIM4, ENABLE);
	TIM_Cmd(TIM4, ENABLE);
}

static uint8_t data[] = { 64, 128, 20, 128, 64, 20 };
void dma_init() {
	DMA_InitTypeDef dma_init;
	RCC_AHB1PeriphClockCmd(RCC_AHB1Periph_DMA1, ENABLE);
	DMA_DeInit(DMA1_Stream5);
	dma_init.DMA_Channel = DMA_Channel_7;
	dma_init.DMA_PeripheralBaseAddr = (uint32_t)&(TIM4->CCR1);
	dma_init.DMA_Memory0BaseAddr = (uint32_t)&data[0];
	dma_init.DMA_DIR = DMA_DIR_MemoryToPeripheral;
	dma_init.DMA_BufferSize = 8;
	dma_init.DMA_PeripheralInc = DMA_PeripheralInc_Disable;
	dma_init.DMA_MemoryInc = DMA_MemoryInc_Enable;
	dma_init.DMA_PeripheralDataSize = DMA_PeripheralDataSize_Byte;
	dma_init.DMA_MemoryDataSize = DMA_PeripheralDataSize_Byte;
	dma_init.DMA_Mode = DMA_Mode_Normal;
	dma_init.DMA_Priority = DMA_Priority_High;
	dma_init.DMA_FIFOMode = DMA_FIFOMode_Disable;
	dma_init.DMA_FIFOThreshold = DMA_FIFOThreshold_HalfFull;
	dma_init.DMA_MemoryBurst = DMA_MemoryBurst_Single;
	dma_init.DMA_PeripheralBurst = DMA_PeripheralBurst_Single;
	DMA_Init(DMA1_Stream5, &dma_init);
	DMA_Cmd(DMA1_Stream5, ENABLE);
}
