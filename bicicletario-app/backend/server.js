const express = require('express');
const authRoutes = require('./routes/authRoutes');
const userRoutes = require('./routes/userRoutes');
const accessRoutes = require('./routes/accessRoutes');

const app = express();

// Middleware para interpretar JSON
app.use(express.json());

// Rotas da API
app.use('/auth', authRoutes); // Rotas de autenticação (login, registro)
app.use('/users', userRoutes); // Rotas para manipular dados dos usuários
app.use('/access', accessRoutes); // Rotas para registros de acesso

// Iniciar o servidor
const PORT = process.env.PORT || 5000;
app.listen(PORT, () => {
    console.log(`Servidor rodando na porta ${PORT}`);
});
