#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "hash_table_acoes.h"

struct Hash * createLista() {
    return (struct Hash *) malloc(sizeof(struct Hash));
}

struct Node * createNode(char *key, char *value) {
    struct Node *node = (struct Node *) malloc(sizeof(struct Node));
    node->key = key;
    node->value = value;
    return node;
};

void insertNode(struct Hash *hash, char *key, char *value) {
    unsigned int index = hashCode(key);
    struct Node *node = hash->lista[index];
    if (node == NULL) {
        hash->lista[index] = createNode(key, value);
    } else {
        while (node->next == NULL) {
            node->next = createNode(key, value);
            break;
        }
        node = node->next;
    }
};

unsigned int hashCode(char *key) {
    unsigned long hash = 5381;
    unsigned long c;
    while (c = *key++) {
        hash = ((hash << 5) + hash) + c;
    }
    return hash % HASH_SIZE;
};

char * procurar(struct Hash * hash, char *key) {
    unsigned int index = hashCode(key);
    struct Node *node = hash->lista[index];
    while (node) {
        if (strcmp(node->key, key) == 0) {
            return node->value;
        }
        node = node->next;
    }
    return "";
};

void imprimir(struct Hash *hash) {
    for(int index = 0; index < HASH_SIZE; index++) {
        struct Node *node = hash->lista[index];
        while (node) {
            printf("Indice: %d - ", index);
            printf("Chave: %s - Valor: %s\n", node->key, node->value);
            node = node->next;
        }
    }
}
