void* create_shared_memory(size_t size) {
  int protection = PROT_READ | PROT_WRITE;
  int visibility = MAP_SHARED | MAP_ANONYMOUS;
  return mmap(NULL, size, protection, visibility, -1, 0);
}

void* shmem = create_shared_memory(sizeof(flags));

typedef struct {
	boolean flag[2];
	int turn; 
}flags;

void P0(){
	flags parent_message = {{true, false}, 0};
	memcpy(shmem, parent_message, sizeof(parent_message));
	while(*((flags)shmem).flag[1] && *((flags)shmem).turn==1); /* и АКТИВНОЕ ОЖИДАНИЕ */
	/* КРИТИЧЕСКИЙ РАЗДЕЛ */
	parent_message = {{false, true}, 1};
	memcpy(shmem, parent_message, sizeof(parent_message));
}

void P1(){
	flags child_message = {{false, true}, 1};
	memcpy(shmem, child_message, sizeof(parent_message));	
	while(*((flags)shmem).flag[0] && *((flags)shmem).turn==0); /* и АКТИВНОЕ ОЖИДАНИЕ */
	/* КРИТИЧЕСКИЙ РАЗДЕЛ */
	child_message = {{true, false}, 0};
	memcpy(shmem, child_message, sizeof(child_message));	
}

void main(){
	memcpy(shmem, parent_message, sizeof(parent_message));	
	if(!fork()){
		P1();
	}
	else{
		P0();
	}
}