// src/firebaseConfig.js

// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";

// Your web app's Firebase configuration
const firebaseConfig = {
  apiKey: "AIzaSyB3ZtEF8DiRijXWgkaQ60SRSzYBzFUv5N8",
  authDomain: "bicicletario-4492c.firebaseapp.com",
  projectId: "bicicletario-4492c",
  storageBucket: "bicicletario-4492c.firebasestorage.app",
  messagingSenderId: "121804029878",
  appId: "1:121804029878:web:b40fdffac92775942d0b17",
  measurementId: "G-GRMQ9QHFKY"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);

export default app;
