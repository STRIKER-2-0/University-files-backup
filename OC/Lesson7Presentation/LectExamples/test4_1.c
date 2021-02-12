#include <stdio.h>
#include <stdlib.h>

#include <unistd.h>
#include <pthread.h>

void * func(void * arg) {
	static int i = 0;

	sleep(2);
	i = *((int *)arg);
	sleep(1);
	printf("In thread(%d). i = %d\n", *((int *)arg), i);
	return NULL;
}

int main(void) {
	
	pthread_t id1, id2;
	int num1 = 1, num2 = 2;
	int res;

	res = pthread_create(&id1, NULL, func, &num1);
	if (res) {
		fprintf(stderr, "%s\n", "ERROR while creating thread 1");
		exit(EXIT_FAILURE);
	} 

	res = pthread_create(&id2, NULL, func, &num2);
	if (res) {
		fprintf(stderr, "%s\n", "ERROR while creating thread 2");
		exit(EXIT_FAILURE);
	}

	pthread_join(id1, NULL);
	pthread_join(id2, NULL);
	printf("%s\n", "The main thread finished\n");

	return EXIT_SUCCESS;
}