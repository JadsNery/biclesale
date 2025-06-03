# Projeto Biclesale - Sistema de Controle de Acesso ao Bicicletário

Este é um sistema completo de gerenciamento de acesso a bicicletários, desenvolvido com foco em segurança, usabilidade e escalabilidade. A aplicação é composta por um backend com Node.js/Express, frontend moderno com React, integração com Firebase e estrutura robusta para testes.

---

## 📁 Estrutura de Pastas

```
Para mais detalhes sobre a estrutura do projeto, consulte [PROJECT_STRUCTURE.md](PROJECT_STRUCTURE.md).

```

---

## ✨ Funcionalidades

- Cadastro e login de usuários
- Registro de entrada e saída no bicicletário
- Listagem de histórico de acessos
- Interface responsiva (React)
- Backend com API REST
- Integração com Firebase (Hosting, Auth, etc.)
- Testes automatizados (unitários e integração)

---

## 🚀 Como executar o projeto localmente

### Requisitos
- Node.js instalado
- Firebase CLI configurado (`firebase login`)

### Passos
1. Clone o repositório
   ```bash
   git clone <https://github.com/JadsNery/biclesale>
   cd Biclesale/bicicletario-app
   ```

2. Instale as dependências do backend e frontend
   ```bash
   cd backend && npm install
   cd ../frontend && npm install
   ```

3. Configure variáveis de ambiente (se aplicável)
   ```bash
   cp .env.example .env
   # edite com suas variáveis
   ```

4. Rode a API
   ```bash
   cd backend
   npm run dev
   ```

5. Rode o frontend
   ```bash
   cd ../frontend
   npm start
   ```

6. (Opcional) Deploy no Firebase
   ```bash
   firebase deploy
   ```

---

## 🎓 Tecnologias utilizadas
- **Frontend**: React, CSS
- **Backend**: Node.js, Express, MongoDB (ou outro)
- **Firebase**: Auth, Hosting, Firestore (se usar)
- **Testes**: Jest, Supertest

---

## 📄 Licença


---

Para dúvidas, ideias ou sugestões, fique à vontade para abrir uma _issue_ ou entrar em contato.

> Projeto desenvolvido como parte do Projeto Integrador na UniSales — 2025


