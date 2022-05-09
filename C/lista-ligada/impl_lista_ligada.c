#include <stdio.h>
#include <stdlib.h>
#include "lista_ligada.h"

struct Node * createNode(int value, struct Node * previous) {

    struct Node * node = (struct Node *) malloc(sizeof(struct Node));
    node -> value = value;
    if (previous) {
        node -> previous = previous;
    }
    return node;
}

void imprimir(struct Node * node) {
    while (node) {
        printf("%d\n", node -> value);
        node = node -> previous;
    }
}

