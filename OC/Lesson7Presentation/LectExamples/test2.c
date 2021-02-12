#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>

void * fun (void *arg) {
	int i = *(int*)arg;
	int k;
	for (k = 0; k < 5; k++) {
		printf("\tThread %d, iteration: %d\n", i, k+1);
		sleep(1);
	}
	return NULL;
}

int main(void) {
	int i;
	pthread_t tid;
	setbuf(stdout, NULL);

	printf("Main Start\n");
	for (i = 0; i < 5; i++) {
		if (pthread_create(&tid, NULL, fun, &i)) {
			fprintf(stderr, "Thread Create Error!\n");
			exit(EXIT_FAILURE);
		}
	}
	sleep(3);
	printf("Main Stop\n");
	return EXIT_SUCCESS;
}