#define MAX_PILHA 100
#define Class struct

Class Node {
    int index;
    char *conteudo;
};

Class Node lista[MAX_PILHA];

void criarNode(int index, char *conteudo);
void empilharNode(Class Node node);
void desempilhar();
void imprimirPilha();

