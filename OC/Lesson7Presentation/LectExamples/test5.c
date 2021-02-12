#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <time.h>

struct thread_arg {
	int num;
	int *buffer;
};

void * thread_func(void * arg) {
	int i;
	struct thread_arg * ptarg = (struct thread_arg *)arg;
	
	ptarg->buffer = (int *)malloc(ptarg->num*sizeof(int));
	if (!(ptarg->buffer)) {
		fprintf(stderr, "Prime numbers: Memory ERROR\n");
		exit(EXIT_FAILURE);
	}
	
	for (i = 0; i < ptarg->num; i++) {
		ptarg->buffer[i] = i;
	}
	
	return ptarg->buffer;
}

int main(void) {
	pthread_t thread;
	struct thread_arg arg;
	void * res;
	
	arg.num = 5; 
	/*
	arg.buffer = (int *)malloc(primes.num*sizeof(int));
	if (arg.buffer == NULL) {
		fprintf(stderr, "Prime numbers: Memory ERROR\n");
		exit(EXIT_FAILURE);
	}
	*/
	
	printf("Initial thread creates child thread\n");
	if (pthread_create(&thread, NULL, thread_func, &arg) != 0) {
		fprintf(stderr, "Error while creating child thread\n");
		return EXIT_FAILURE;
	}
	
	printf("Parent thread is waiting child threads\n");
	if (!pthread_equal(pthread_self(), thread)) {
		if (pthread_join(thread, &res) != 0) {
			fprintf(stderr, "Child thread join error\n");
		}
	}
	

	{
		int i;
		for(i = 0; i < arg.num; i++)
			printf("Number %d: %d\n", i+1, arg.buffer[i]);
	}
	{
		int i;
		for(i = 0; i < arg.num; i++)
			printf("Number %d: %d\n", i+1, ((int*)res)[i]);
	}
	
	free(arg.buffer);
	printf("res %p\n", res);
	printf("buf %p\n", arg.buffer);
	//NULL at both
	arg.buffer = NULL;
	res = NULL;
	
	
	printf("The programm is finished\n");
	
	return EXIT_SUCCESS;
}
