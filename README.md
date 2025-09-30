# Manual do Usuário - Sistema de Agenda Digital

## Visão Geral
O Sistema de Agenda Digital é uma aplicação Java desenvolvida para gerenciar reservas utilizando ArrayList e programação orientada a objetos. O sistema permite incluir, alterar, excluir, consultar e listar reservas de forma interativa através do console.

## Estrutura do Projeto
```
avaliacao_logica_programacao_03/
├── src/
│   ├── Principal.java    # Classe principal com menu e funcionalidades
│   └── Reserva.java      # Classe que representa uma reserva
├── bin/                  # Arquivos compilados (.class)
└── README.md            # Este manual
```

## Como Executar a Aplicação

### Pré-requisitos
- Java Development Kit (JDK) 8 ou superior instalado
- Terminal/Prompt de comando disponível

### Compilação
```bash
javac -d bin src\*.java
```

### Execução
```bash
java -cp bin Principal
```

## Funcionalidades da Aplicação

### Menu Principal
Ao iniciar a aplicação, você verá o seguinte menu:

```
==================================================
              MENU PRINCIPAL
==================================================
1 - Incluir nova reserva
2 - Alterar reserva existente
3 - Excluir reserva
4 - Consultar reserva específica
5 - Listar todas as reservas
0 - Sair do sistema
==================================================
```

### 1. Incluir Nova Reserva

**Funcionalidade:** Permite adicionar uma nova reserva à agenda.

**Como usar:**
1. Selecione a opção "1" no menu principal
2. Digite o nome da pessoa que fez a reserva
3. Digite a data no formato dd/mm/aaaa (ex: 15/10/2025)
4. Digite a hora no formato hh:mm (ex: 14:30)

**Validações:**
- Nome não pode estar vazio
- Data deve estar no formato dd/mm/aaaa
- Hora deve estar no formato hh:mm
- Não permite reservas duplicadas (mesma data e hora)

**Exemplo de uso:**
```
=== INCLUIR NOVA RESERVA ===
Digite o nome da pessoa: João Silva
Digite a data (dd/mm/aaaa): 15/10/2025
Digite a hora (hh:mm): 14:30

✓ Reserva incluída com sucesso!
Detalhes da reserva:
Nome: João Silva         | Data: 15/10/2025   | Hora: 14:30
```

### 2. Alterar Reserva Existente

**Funcionalidade:** Permite modificar dados de uma reserva já cadastrada.

**Como usar:**
1. Selecione a opção "2" no menu principal
2. Escolha o número da reserva que deseja alterar
3. Selecione o que deseja alterar:
   - 1 - Nome
   - 2 - Data
   - 3 - Hora
   - 4 - Todos os dados

**Validações:**
- Mantém as mesmas validações da inclusão
- Verifica conflitos ao alterar data/hora

**Exemplo de uso:**
```
=== ALTERAR RESERVA EXISTENTE ===
Reservas cadastradas:
------------------------------------------------------------
 1. Nome: João Silva         | Data: 15/10/2025   | Hora: 14:30

Digite o número da reserva que deseja alterar: 1

Reserva atual:
Nome: João Silva         | Data: 15/10/2025   | Hora: 14:30

O que deseja alterar?
1 - Nome
2 - Data
3 - Hora
4 - Todos os dados
Opção: 1
Novo nome: João Santos
✓ Nome alterado com sucesso!
```

### 3. Excluir Reserva

**Funcionalidade:** Remove uma reserva da agenda.

**Como usar:**
1. Selecione a opção "3" no menu principal
2. Escolha o número da reserva que deseja excluir
3. Confirme a exclusão digitando "s" ou "sim"

**Exemplo de uso:**
```
=== EXCLUIR RESERVA ===
Reservas cadastradas:
------------------------------------------------------------
 1. Nome: João Santos        | Data: 15/10/2025   | Hora: 14:30

Digite o número da reserva que deseja excluir: 1

Reserva a ser excluída:
Nome: João Santos        | Data: 15/10/2025   | Hora: 14:30

Confirma a exclusão? (s/n): s
✓ Reserva excluída com sucesso!
```

### 4. Consultar Reserva Específica

**Funcionalidade:** Busca reservas por diferentes critérios.

**Tipos de busca disponíveis:**
1. Por nome (busca parcial, ignora maiúsculas/minúsculas)
2. Por data (busca exata ou parcial)
3. Por hora (busca exata ou parcial)
4. Busca geral (em todos os campos)

**Como usar:**
1. Selecione a opção "4" no menu principal
2. Escolha o tipo de busca (1-4)
3. Digite o termo de busca

**Exemplo de uso:**
```
=== CONSULTAR RESERVA ESPECÍFICA ===
Buscar por:
1 - Nome
2 - Data
3 - Hora
4 - Busca geral (em todos os campos)
Opção: 1
Digite o termo de busca: João

=== RESULTADOS DA BUSCA ===
Encontrada(s) 1 reserva(s):
------------------------------------------------------------
 1. Nome: João Santos        | Data: 15/10/2025   | Hora: 14:30
```

### 5. Listar Todas as Reservas

**Funcionalidade:** Exibe todas as reservas cadastradas na agenda.

**Como usar:**
1. Selecione a opção "5" no menu principal
2. O sistema exibirá todas as reservas numeradas

**Exemplo de uso:**
```
=== LISTA DE TODAS AS RESERVAS ===
Total de reservas: 3
------------------------------------------------------------
 1. Nome: João Santos        | Data: 15/10/2025   | Hora: 14:30
 2. Nome: Maria Silva        | Data: 16/10/2025   | Hora: 09:00
 3. Nome: Pedro Costa        | Data: 17/10/2025   | Hora: 16:45
```

## Características Técnicas

### Classe Reserva
- **Atributos:** nome (String), data (String), hora (String)
- **Métodos:** construtores, getters, setters, toString(), contem()
- **Validações:** formatação de data e hora

### Classe Principal
- **Estrutura de dados:** ArrayList<Reserva>
- **Interface:** Menu interativo no console
- **Validações:** entrada de dados, conflitos de agendamento
- **Funcionalidades:** CRUD completo (Create, Read, Update, Delete)

## Tratamento de Erros

### Erros Comuns e Soluções
1. **"Data deve estar no formato dd/mm/aaaa!"**
   - Solução: Digite a data exatamente como 15/10/2025

2. **"Hora deve estar no formato hh:mm!"**
   - Solução: Digite a hora como 14:30 (com dois dígitos)

3. **"Já existe uma reserva para esta data e hora!"**
   - Solução: Escolha uma data/hora diferente

4. **"Nome não pode estar vazio!"**
   - Solução: Digite um nome válido

5. **"Número de reserva inválido!"**
   - Solução: Digite um número dentro da lista apresentada

## Dicas de Uso

1. **Formato de Data:** Sempre use dd/mm/aaaa (ex: 01/12/2025)
2. **Formato de Hora:** Sempre use hh:mm (ex: 08:30, 14:00)
3. **Busca por Nome:** Não diferencia maiúsculas de minúsculas
4. **Confirmação:** Para excluir, digite "s", "S", "sim" ou "SIM"
5. **Navegação:** Pressione ENTER para retornar ao menu após cada operação

## Limitações

- As reservas são armazenadas apenas em memória (perdidas ao fechar o programa)
- Não há persistência em arquivo ou banco de dados
- Formato de data e hora fixo (brasileiro)
- Não há validação de datas futuras/passadas
- Não há controle de usuários ou permissões

## Conclusão

O Sistema de Agenda Digital atende a todos os requisitos propostos:
- ✅ Uso de ArrayList para armazenamento
- ✅ Classe Reserva com atributos obrigatórios
- ✅ Todas as 5 funcionalidades implementadas
- ✅ Menu interativo e validações
- ✅ Código bem estruturado e documentado

