struct Node {
    int value;
    struct Node *previous;
};

struct Node * createNode(int value, struct Node * previous);

void imprimir(struct Node * node);
