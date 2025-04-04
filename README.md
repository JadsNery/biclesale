# Projeto Biclesale - Sistema de Controle de Acesso ao Bicicletário

Este é um sistema completo de gerenciamento de acesso a bicicletários, desenvolvido com foco em segurança, usabilidade e escalabilidade. A aplicação é composta por um backend com Node.js/Express, frontend moderno com React, integração com Firebase e estrutura robusta para testes.

---

## 📁 Estrutura de Pastas

```
/Biclesale/
├── bicicletario-app/                      # App principal
│   ├── backend/                           # API REST com Express
│   │   ├── config/                        # Configuração do banco de dados
│   │   │   └── db.js
│   │   ├── controllers/                   # Controladores da API
│   │   │   ├── accessController.js
│   │   │   ├── authController.js
│   │   │   └── userController.js
│   │   ├── models/                        # Modelos de dados (ex: User, AccessLog)
│   │   │   ├── AccessLog.js
│   │   │   └── User.js
│   │   ├── routes/                        # Rotas da API
│   │   │   ├── accessLogs.js
│   │   │   ├── auth.js
│   │   │   └── users.js
│   │   ├── utils/                         # Funções auxiliares (ex: validações)
│   │   └── server.js                      # Ponto de entrada da API
│   
│   ├── database/                          # Migrations e seeds (inicialização do banco)
│   │   ├── migrations/
│   │   └── seeds/
│   
│   ├── frontend/                          # Aplicativo React (interface do usuário)
│   │   ├── public/                        # Arquivos estáticos (index.html etc.)
│   │   │   ├── assets/
│   │   │   ├── favicon.ico
│   │   │   ├── index.html
│   │   │   └── manifest.json
│   │   └── src/                           # Código fonte React
│   │       ├── assets/                    # Imagens, logos, etc.
│   │       │   └── images/
│   │       │       └── logo.png
│   │       ├── components/                # Componentes reutilizáveis
│   │       │   ├── Button.js
│   │       │   ├── Footer.js
│   │       │   ├── Header.js
│   │       │   └── InputField.js
│   │       ├── pages/                     # Páginas principais (Login, Dashboard, etc.)
│   │       │   ├── DashboardPage.js
│   │       │   ├── HistoryPage.js
│   │       │   ├── LoginPage.js
│   │       │   └── RegisterPage.js
│   │       ├── config/                    # Configuração do Firebase
│   │       │   └── firebaseConfig.js
│   │       ├── styles/                    # Estilos CSS
│   │       │   └── styles.css
│   │       ├── App.js                     # App principal
│   │       └── index.js                   # Entrada da aplicação
│   
│   └── tests/                             # Testes automatizados
│       ├── integration/                   # Testes de integração
│       │   └── integration.test.js      
│       ├── unit/                          # Testes unitários
│       │   ├── authController.test.js
│       │   └── userModel.test.js
│       ├── package.json
│       └── README.md
│
├── functions/                             # Cloud Functions do Firebase (se aplicável)
│   ├── node_modules/                      # Dependências de funções
│   ├── package.json                       # Dependências do Firebase Functions
│   ├── package-lock.json
│   └── README.md
│
└── README.md                              # Este arquivo

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
   git clone <url-do-repositorio>
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
Este projeto está licenciado sob a Licença MIT. Veja o arquivo `LICENSE` para mais informações.

---

Para dúvidas, ideias ou sugestões, fique à vontade para abrir uma _issue_ ou entrar em contato.

> Projeto desenvolvido como parte do Projeto Integrador na UniSales — 2025


