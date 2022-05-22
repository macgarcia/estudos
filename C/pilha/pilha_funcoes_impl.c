#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "pilha_funcoes.h"

int topo = -1;
int qtde = 0;

void criarNode(int index, char *conteudo) {
    Class Node novo_node;
    novo_node.index = index;
    novo_node.conteudo = conteudo;
    empilharNode(novo_node);
};

void empilharNode(Class Node node) {
    topo++;
    qtde++;
    lista[topo] = node;
};

void desempilhar() {
    qtde--;
    topo--;
};

void imprimirPilha() {
    for (int i = topo; i >= 0; i--) {
        printf("Indice: %d - Elemento: %d - Valor: %s\n", i, lista[i].index, lista[i].conteudo);
    }
};
