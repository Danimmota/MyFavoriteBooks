# 📚 MyFavoriteBooks
Um aplicativo Android nativo realizado em Kotlin para organizar e favoritar livros.

---

## 📌 1. Descrição do Problema
A grande quantidade de livros que descubro em lojas virtuais, bibliotecas digitais e recomendações nas redes sociais sempre me fez perder o controle das obras que quero ler.
Como gosto muito de leitura, eu sentia falta de uma forma rápida, simples e acessível de organizar meus livros favoritos, registrar títulos que despertam meu interesse e navegar entre eles diretamente no celular.
Foi dessa necessidade pessoal que nasceu a ideia de criar o *MyFavoriteBooks*.

O *MyFavoriteBooks* surge para solucionar esse problema oferecendo uma interface intuitiva com navegação fluida, cadastro de livros e gerenciamento de favoritos.

---

## 🌱 2. Justificativa
O incentivo à leitura é um pilar importante para o desenvolvimento intelectual, social e cultural.  
Este aplicativo se relaciona diretamente com a **ODS 4 — Educação de Qualidade**, especialmente com a meta:

- **4.6 — Garantir que todas as pessoas adquiram conhecimentos fundamentais e habilidades necessárias para promover aprendizagem ao longo da vida.**

Ao facilitar o acesso à organização pessoal de leitura, o app contribui para construir hábitos educacionais positivos, reforçando práticas culturais e aumentando o engajamento com literatura.

---

## 🎯 3. Público-Alvo
O aplicativo beneficia principalmente:

- 📖 **Leitores ocasionais** que desejam acompanhar livros de interesse.
- 📚 **Estudantes** que precisam registrar rapidamente obras para trabalhos ou pesquisas.
- 📝 **Pessoas que recebem recomendações de livros** e querem armazená-las para lembrar depois.
- 📱 **Usuários que buscam uma experiência simples e direta** para organizar suas leituras.

A simplicidade e foco tornam o app útil para qualquer faixa etária e nível de familiaridade tecnológica.

---

## 🎯 4. Objetivos do App
Objetivos mensuráveis do MyFavoriteBooks:

- ✔ Permitir que o usuário registre e visualize livros.
- ✔ Classificar livros como favoritos com apenas um toque.
- ✔ Manter uma navegação clara entre Home e Favoritos.
- ✔ Gerar uma experiência 100% offline, sem dependência de banco de dados remoto.
- ✔ Oferecer interface fluida seguindo padrões de usabilidade do Material Design.

---

## 📱 5. Tipo de Aplicação
O MyFavoriteBooks é uma **aplicação nativa Android**, desenvolvida em:

- **Kotlin**
- **Android SDK**
- **Jetpack Navigation**
- **Material Design Components**

Escolhida por garantir melhor performance, recursos de UI modernos e integração completa com o ecossistema Android.

---

## 6. Screenshots do app

- [Home](docs/images/home.png)
- [Favorites](docs/images/favorites.png)
- [Details](docs/images/details.png)

---
## 🛠️ 7. Instalação e Uso

### **Instalação (Ambiente de Desenvolvimento)**
1. Clone este repositório:
   ```bash
   git clone https://github.com/seu-usuario/MyFavoriteBooks.git
   ```
2. Abra o projeto no Android Studio (versão recomendada abaixo).

3. Aguarde o Gradle sincronizar.

4. Conecte um dispositivo físico ou abra um emulador Android.

5. Rode o app com ▶ Run App.

### **Uso**
- A tela inicial exibe a lista de livros cadastrados.

- Toque em um livro para vê-lo com mais detalhes.

- Use a Bottom Navigation para navegar entre:

    - Home — todos os livros
    - Favoritos — apenas livros marcados como favoritos
- Para favoritar ou desfavoritar um livro, toque no ícone de coração.

❗ Não há necessidade de credenciais — o aplicativo funciona offline.

## 8. Requisitos do Sistema

### Sistema Operacional

- Android 8.0 (API 26) ou superior.

### Ambiente de Desenvolvimento

- Android Studio Giraffe ou superior.
- JDK 17 (recomendado pelo Android Studio).

### Dependências Principais
    (gerenciadas automaticamente pelo Gradle)

- `androidx.navigation:navigation-fragment-ktx`
- `androidx.navigation:navigation-ui-ktx`
- `com.google.android.material:material`
- `androidx.constraintlayout:constraintlayout`
- `androidx.core:core-ktx`