#include <stdio.h>
#include <stdlib.h>

#include <unistd.h>
#include <pthread.h>

void * func(void * arg) {
	/*static*/ int i = 0;
	int num = *((int *)arg);

	//sleep(2);
	i = num*num;
	sleep(1);
	printf("In thread(%d). i = %d\n", num, i);
	return (void*)&i;
}

int main(void) {
	
	pthread_t id1, id2;
	int num1 = 1, num2 = 2;
	int res, res1, res2;
	void * ret;

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

	//pthread_join(id1, (void*)&res1);
	sleep(2);
	pthread_join(id1, &ret);
	res1 = *((int *) ret);
	//pthread_join(id2, (void*)&res2);
	pthread_join(id1, &ret);
	res2 = *((int *) ret);
	printf("%s%d%s%d\n", "res1: ", res1, "\tres2: ", res2);

	printf("%s\n", "The main thread finished\n");

	return EXIT_SUCCESS;
}