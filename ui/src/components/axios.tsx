import axios from "axios";

const postman = axios.create({
  baseURL: "http://localhost:9090/",
  timeout: 500,
  headers: { "Access-Control-Allow-Origin": true },
});

export default postman;
