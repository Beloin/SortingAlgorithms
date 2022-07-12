# Heap

## Tamanho do Heap

Tamanho = Altura, Sendo assim, temos que a cada "andar" da árvore, há no máximo 2 Nós.
Então Podemos dizer que uma árvore de altura h, possui no máximo `2^(h+1) - 1` nós. Prosseguindo, podemos ainda afirmar que o tamanho de uma árvore de altura h - 1 é de `2^(h) - 1`.
Logo, o tamanho mínimo de nós em uma árvore de tamanho h é `2^h` então podemos afirmar que:
``` 
    n >= 2^h && n < 2^(h+1)
    O que significa que:
    h <= log(n) ou h + 1 > log(n)
    No final das contas, temos que h = 	\lfloor log(n) \rfloor
```

# Processo de criação

1. Implementar o teste do HeapSort
2. Implementar o HeapSort
3. Criar forma de ensinar Heap Sort
4. Gravar Heap Sort