#include <stdio.h>
#include <stdlib.h>
#include "lista_ligada.h"

int main() {
    struct Node *primeiro = createNode(101, NULL);
    struct Node *segundo = createNode(202, primeiro);
    struct Node *terceiro = createNode(303, segundo);
    struct Node *quarto = createNode(404, terceiro);
    struct Node *quinto = createNode(505, quarto);
    imprimir(quinto);
}
