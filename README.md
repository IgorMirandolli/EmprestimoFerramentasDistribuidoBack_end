# 💻 Projeto de Empréstimo de Ferramentas – Java (4ª Fase)

O presente trabalho tem como objetivo projetar e desenvolver um sistema distribuído em duas camadas (front-end e back-end), aplicando os conceitos de arquiteturas baseadas em serviços com a tecnologia Java RMI (Remote Method Invocation).
---

## 📌 Objetivos do Projeto

- Aplicar os conceitos de sistemas distribuídos no desenvolvimento de uma aplicação em arquitetura de duas camadas.
- Compreender e implementar a comunicação entre processos utilizando Java RMI.
- Promover a reutilização de software legado, modernizando sua estrutura e incorporando boas práticas de modularização.
- Desenvolver a capacidade de projetar, implementar e documentar um sistema baseado em serviços.

---

## 🧩 Requisitos Funcionais

| Código  | Nome                             | Descrição |
|----------|----------------------------------|------------|
| **RF001** | **CRUD de Amigos** | O sistema deve permitir ao usuário **cadastrar**, **visualizar**, **editar** e **excluir** registros de amigos. |
| **RF002** | **CRUD de Ferramentas** | O sistema deve permitir ao usuário **cadastrar**, **visualizar**, **editar** e **excluir** registros de ferramentas. |
| **RF003** | **Registro de Empréstimos** | O sistema deve permitir **registrar um novo empréstimo**, associando um amigo previamente cadastrado a uma ou mais ferramentas disponíveis. |
| **RF004** | **Registro de Devolução** | O sistema deve permitir **registrar a devolução** de ferramentas emprestadas, atualizando o **status do empréstimo**. |
| **RF005** | **Listagem de Ferramentas Disponíveis** | O sistema deve fornecer uma funcionalidade para **listar todas as ferramentas** que não estão associadas a um **empréstimo ativo**. |
| **RF006** | **Histórico de Empréstimos** | O sistema deve permitir **consultar o histórico completo de empréstimos**, contendo informações sobre amigos, ferramentas, datas de empréstimo e devolução. |

---

## 🧱 Requisitos Não Funcionais

| Código  | Nome                        | Descrição |
|----------|-----------------------------|------------|
| **RNF001** | **Arquitetura de Comunicação** | O sistema deve operar em uma arquitetura Cliente-Servidor, utilizando exclusivamente **Java RMI (Remote Method Invocation)** para a comunicação entre as camadas. |
| **RNF002** | **Persistência de Dados** | Todos os dados (amigos, ferramentas e empréstimos) devem ser armazenados em um **banco de dados local** acessível apenas pelo servidor. O cliente não deve ter acesso direto ao banco. |
| **RNF003** | **Distribuição** | O sistema deve permitir que cliente e servidor sejam executados em **máquinas distintas**, comunicando-se através de uma **rede local (LAN)** ou **Internet**. |
| **RNF004** | **Modularidade** | O código-fonte deve ser estruturado de forma **modular**, com separação clara entre as camadas de **modelo**, **visão**, **controle** e **comunicação**, facilitando **manutenção e reuso**. |
| **RNF005** | **Tecnologia Utilizada** | O sistema deve ser desenvolvido inteiramente em **Java**, utilizando **Swing** para a interface gráfica do cliente e **SQLite** para o armazenamento de dados no servidor. |

---

## 🧱 Estrutura Inicial

O sistema conta com a seguintes estruturas principais:

- `DAO`: Contém as classes responsáveis pelo acesso e manipulação dos dados, seguindo o padrão Data Access Object (DAO) para realizar operações de persistência e manter a separação entre a lógica de dados e a de negócio.
- `Principal`: Contém a classe principal do cliente, responsável por inicializar o sistema e estabelecer a conexão com o servidor RMI.
- `Modelo`: Contém as classes reais que representam os dados manipulados pelo sistema. Essas classes implementam Serializable para permitir a transmissão dos objetos entre o cliente e o servidor via RMI.
- `RMI`: O pacote rmi é responsável por estabelecer a comunicação remota entre o cliente (front-end) e o servidor (back-end) utilizando a tecnologia Java RMI.

---

## 🚀 Tecnologias Utilizadas

- [Java](https://www.oracle.com/java/) - Versão: 21
- [NetBeans](https://netbeans.apache.org/) - Versão: 21
- [SQLite3](https://www.sqlite.org/index.html) - Versão: 3.49.2
- [Maven](https://maven.apache.org/)
- [JUnit](https://junit.org/) - Versão: 5.9.0

---

## 🧠 Integrantes do Grupo

| Nome                            | RA          | Conta GitHub |
|---------------------------------|--------------|---------------|
| Igor Vinicius Sotili Mirandolli | 1072416369   | [IgorMirandolli](https://github.com/IgorMirandolli) |
| Bernardo Santos Vieira          | 1072415392   | [BernardoSVieira](https://github.com/BernardoSVieira) |
| Guilherme Mitsuo Honda          | 1072416697   | [lmitsuol](https://github.com/lmitsuol) |
| Victor Hasse                    | 10724111755  | [victorhasse](https://github.com/victorhasse) |


## Links

- Front-End: [Link do Projeto](https://github.com/IgorMirandolli/EmprestimoFerramentasDistribuidoFront-end/)
- Back-End: [Link do Projeto](https://github.com/IgorMirandolli/EmprestimoFerramentasDistribuidoBack-end)
- Documento: [Link do Documento](https://docs.google.com/document/d/1zBONAHv6A6uxAW3HqB1aM5DrpkD6jwheI6X3jT_6RRw/edit?usp=sharing)
- Slides: [Link dos Slides](https://docs.google.com/presentation/d/1HQ-3cebUXkrgELHy0N0X6Gr1T5wkP3MI_hATqlGEPkk/edit?usp=sharing)
