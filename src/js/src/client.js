import fetch from "unfetch";

export const getAllStudents = () => fetch("api/students");

export const addNewStudent = (student) =>
  fetch("api/students", {
    headers: {
      Accept: "application/json, text/plain",
      "Content-Type": "application/json;charset=UTF-8",
    },
    method: "POST",
    body: JSON.stringify(student),
  });
