#include "stm32f4xx.h"
#include "stm32f4xx_gpio.h"
#include "stm32f4xx_rcc.h"
#include "stm32f4xx_tim.h"
#include "misc.h"
#include "init.h"

enum State{
	LED4,
	LED3,
	LED5,
	LED6
};
enum Mode{
	RISE,
	FALL
};
const int stages = 10;
static uint32_t counter = 0;
static enum State state = LED4;
static enum Mode mode = RISE;

void logic(uint32_t* brightness);

int main(void){
	init();

	uint32_t brightness_arr[stages];
	for(int i = 0; i < stages; i++)
		brightness_arr[i] = (uint32_t) (333 / stages * i);	//666/2

	while(1){
		logic(brightness_arr + counter);
	}
}

void TIM2_IRQHandler(void) {
    if (TIM_GetITStatus(TIM2, TIM_IT_Update) != RESET) {
        TIM_ClearITPendingBit(TIM2, TIM_IT_Update);
        if(mode == RISE)
        	counter++;
        else
            counter--;

        if(counter == stages || counter == 0){
        	if(mode == RISE){
        		mode = FALL;
        		counter = 9;
        	}
        	else{
        		mode = RISE;
        		state++;
        	}
        }
    }
}

void logic(uint32_t* brightness){
	switch(state){
		case LED4:
			TIM4->CCR1 = *brightness;
			TIM4->CCR4 = 0;
			break;
		case LED3:
			TIM4->CCR2 = *brightness;
			TIM4->CCR1 = 0;
			break;
		case LED5:
			TIM4->CCR3 = *brightness;
			TIM4->CCR2 = 0;
			break;
		case LED6:
			TIM4->CCR4 = *brightness;
			TIM4->CCR3 = 0;
			break;
		default:
			state = LED4;
	}
}

