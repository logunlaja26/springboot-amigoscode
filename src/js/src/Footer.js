import React from "react";
import Container from "./Container";
import { Avatar, Button } from "antd";
//import Button from '@material-ui/core/Button';
import "./Footer.css";

const Footer = (props) => (
  <div className="footer">
    <Container>
      {props.numberOfStudents ? (
        <Avatar
          style={{ backgroundColor: "#f56a00", marginRight: "5px" }}
          size="large"
        >
          {props.numberOfStudents}
        </Avatar>
      ) : null}
      <Button
        onClick={() => {
          console.log("button click");
        }}
        color="primary"
      >
        {" "}
        Add new student +
      </Button>
    </Container>
  </div>
);

export default Footer;
