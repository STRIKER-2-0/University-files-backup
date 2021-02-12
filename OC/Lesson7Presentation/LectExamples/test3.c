#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <pthread.h>

/* Argument */
typedef struct {
	char * str;
	int reps;
	int delay;
} TSArg;

void * func(void * arg) {
	TSArg * a = (TSArg*)arg;
	//TSArg a = *(TSArg*)arg;
	int i;
	for (i = 0; i < a->reps; i++) {
	//for (i = 0; i < a.reps; i++) {
		printf("TID %u: %s\n", (unsigned int)pthread_self(), a->str);
		//printf("TID %u: %s\n", (unsigned int)pthread_self(), a.str);
		sleep(a->delay);
		//sleep(a.delay);
	}
	return NULL;
}

void create_threads(void) {
	int i, code, reps, delay;
	TSArg arg_arr[] = {{"Hello", 5, 1}, {"Good-Bye", 3, 2}, {"Hi-Hi-Hi", 8, 1}};
	int num = sizeof arg_arr / sizeof(TSArg);
	pthread_t *tid_arr;
	tid_arr = (pthread_t*)calloc(sizeof(pthread_t), num);
	if (!tid_arr) {
		perror("TID Array Creation Error!\n");
		exit(EXIT_FAILURE);
	}
	for (i = 0; i < num; i++) {
		printf("\tStr: %s, reps: %d, delay: %d\n", arg_arr[i].str, arg_arr[i].reps, arg_arr[i].delay);
	}
	for (i = 0; i < num; i++) {
		code = pthread_create(tid_arr+i, NULL, func, arg_arr+i);
		if (code) {
			fprintf(stderr, "Thread Create Error: %d\n", code);
			exit(EXIT_FAILURE);
		}
	}
	//sleep(1);
}

int main(void) {
	printf("Main. Creting Threads\n");
	create_threads();
	printf("Main. Exit from Main Thread\n");

	pthread_exit(NULL);

	return EXIT_SUCCESS;
}
