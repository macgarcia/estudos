#include <stdio.h>
#include <stdlib.h>
#include "pilha_funcoes.h"

int main() {
    criarNode(1, "Marcos");
    criarNode(2, "Antonio");
    criarNode(3, "Carlos");
    criarNode(4, "Garcia");
    imprimirPilha();
    desempilhar();
    printf("--------------------------\n");
    imprimirPilha();
    desempilhar();
    printf("--------------------------\n");
    imprimirPilha();
    return 0;
}
