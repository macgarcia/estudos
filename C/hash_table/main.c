#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "hash_table_acoes.h"

int main() {
    // By Fabio Akita.

    struct Hash *hash = createLista();
    insertNode(hash, "Marcos", "Garcia");
    insertNode(hash, "Antonio", "Carlos");
    insertNode(hash, "Antonio", "PEDRO");
    imprimir(hash);
    return 0;
}
