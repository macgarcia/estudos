#define HASH_SIZE 100

struct Node {
    char *key;
    char *value;
    struct Node *next;
};

struct Hash {
    struct Node *lista[HASH_SIZE];
};

struct Hash * createLista();

struct Node * createNode(char *key, char *value);

void insertNode(struct Hash *hash, char *key, char *value);

unsigned int hashCode();

char * procurar(struct Hash * hash, char *key);

void imprimir(struct Hash *hash);
