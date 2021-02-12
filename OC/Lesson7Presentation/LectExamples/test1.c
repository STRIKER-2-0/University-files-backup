#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>

pthread_t tid;

void * fun (void *arg) {
	int k;
	for (k = 0; k < 5; k++) {
		printf("\tThread id: %u, iteration: %d\n", (unsigned int)tid, k+1);
		sleep(1);
	}
	return NULL;
}

int main(void) {
	setbuf(stdout, NULL);

	printf("Main Start\n");
	if (pthread_create(&tid, NULL, fun, NULL)) {
		fprintf(stderr, "Thread Create Error!\n");
		exit(EXIT_FAILURE);
	}
	sleep(3);
	//pthread_exit(NULL);
	printf("Main Stop\n");
	return EXIT_SUCCESS;
}