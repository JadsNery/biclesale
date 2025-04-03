const { onRequest } = require("firebase-functions/v2/https");
const { logger } = require("firebase-functions");

// Função HTTP simples
exports.helloWorld = onRequest((req, res) => {
  logger.info("Hello logs!", { structuredData: true }); // Exemplo de uso do logger
  res.send("Hello from Firebase!");
});

// Outra função HTTP
exports.anotherFunction = onRequest((req, res) => {
  logger.info("Another function was called.");
  res.send("This is another function.");
});
