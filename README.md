# Manual do Usuário - Sistema de Agenda Digital

## Visão Geral
O Sistema de Agenda Digital é uma aplicação Java simples e eficiente para gerenciar reservas utilizando ArrayList e programação orientada a objetos. O sistema permite incluir, alterar, excluir, consultar e listar reservas através de um menu interativo no console.

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

## Menu da Aplicação

Ao iniciar, você verá o seguinte menu:

```
=== AGENDA DIGITAL ===

--- MENU ---
1 - Incluir reserva
2 - Alterar reserva
3 - Excluir reserva
4 - Consultar reserva
5 - Listar reservas
0 - Sair
Escolha: 
```

## Funcionalidades

### 1. Incluir Reserva
**O que faz:** Adiciona uma nova reserva à agenda.

**Como usar:**
1. Digite "1" no menu
2. Digite o nome da pessoa
3. Digite a data no formato dd/mm/aaaa
4. Digite a hora no formato hh:mm

**Exemplo:**
```
--- INCLUIR RESERVA ---
Nome: João Silva
Data (dd/mm/aaaa): 15/10/2025
Hora (hh:mm): 14:30
Reserva incluída com sucesso!
```

### 2. Alterar Reserva
**O que faz:** Modifica os dados de uma reserva existente.

**Como usar:**
1. Digite "2" no menu
2. Escolha o número da reserva que deseja alterar
3. Digite os novos dados (nome, data, hora)

**Exemplo:**
```
--- ALTERAR RESERVA ---
1. Nome: João Silva         | Data: 15/10/2025   | Hora: 14:30
Número da reserva: 1
Novo nome: João Santos
Nova data: 16/10/2025
Nova hora: 15:00
Reserva alterada com sucesso!
```

### 3. Excluir Reserva
**O que faz:** Remove uma reserva da agenda.

**Como usar:**
1. Digite "3" no menu
2. Escolha o número da reserva que deseja excluir

**Exemplo:**
```
--- EXCLUIR RESERVA ---
1. Nome: João Santos        | Data: 16/10/2025   | Hora: 15:00
Número da reserva: 1
Reserva excluída com sucesso!
```

### 4. Consultar Reserva
**O que faz:** Busca reservas por nome.

**Como usar:**
1. Digite "4" no menu
2. Digite o nome (ou parte do nome) para buscar

**Exemplo:**
```
--- CONSULTAR RESERVA ---
Digite o nome para buscar: João
1. Nome: João Silva         | Data: 15/10/2025   | Hora: 14:30
2. Nome: João Santos        | Data: 16/10/2025   | Hora: 15:00
```

### 5. Listar Reservas
**O que faz:** Mostra todas as reservas cadastradas.

**Como usar:**
1. Digite "5" no menu
2. O sistema exibe todas as reservas numeradas

**Exemplo:**
```
--- TODAS AS RESERVAS ---
1. Nome: João Silva         | Data: 15/10/2025   | Hora: 14:30
2. Nome: Maria Costa        | Data: 17/10/2025   | Hora: 09:00
3. Nome: Pedro Santos       | Data: 18/10/2025   | Hora: 16:45
```

## Características Técnicas

### Classe Reserva
- **Atributos:** nome, data, hora (todos String)
- **Construtor:** `Reserva(String nome, String data, String hora)`
- **Métodos:** getters, setters e toString()
- **Formato de exibição:** "Nome: [nome] | Data: [data] | Hora: [hora]"

### Classe Principal
- **Armazenamento:** ArrayList<Reserva> para as reservas
- **Interface:** Menu simples no console
- **Navegação:** Números de 0-5 para as opções
- **Entrada:** Scanner para capturar dados do usuário

## Dicas de Uso

1. **Formatos recomendados:**
   - Data: dd/mm/aaaa (ex: 15/10/2025)
   - Hora: hh:mm (ex: 14:30)

2. **Busca por nome:** Digite apenas parte do nome para encontrar
   - Buscar "João" encontra "João Silva" e "João Santos"

3. **Numeração:** As reservas são numeradas automaticamente
   - Use os números mostrados para alterar/excluir

4. **Sair:** Digite "0" para encerrar o programa


## Requisitos Atendidos

- ✅ **Classe Reserva** com atributos nome, data, hora
- ✅ **ArrayList** para armazenar objetos Reserva  
- ✅ **Incluir** nova reserva
- ✅ **Alterar** reserva existente
- ✅ **Excluir** reserva
- ✅ **Consultar** reserva específica
- ✅ **Listar** todas as reservas
- ✅ **Menu interativo** no console
- ✅ **Uso do Scanner** para entrada de dados

## Limitações

- Dados armazenados apenas em memória (não salva em arquivo)
- Busca funciona apenas por nome
- Sem validação rigorosa de formatos
- Sem verificação de conflitos de horário

