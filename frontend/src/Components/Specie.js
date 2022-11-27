import React from "react";
import { useEffect, useState } from "react";
import axios from "axios";
import { useParams } from "react-router-dom";
import "../style/Specie.css";
import { Link } from "react-router-dom";

function Specie({ match }) {
  let { specie } = useParams();
  const [title, setTitle] = useState([]);
  let allAnim = [];
  let finalAnim = [];
  for (let i = 0; i < title.length; i++) {
    let obj = title[i];

    allAnim.push(obj.name);

    console.log(obj.name);
  }
  allAnim.forEach((item, index) => {
    finalAnim.push(<li key={index}>{item}</li>);
  });
  useEffect(() => {
    async function getStoreData() {
      const response = await axios.get(
        `http://localhost:8080/api/type/${specie}`
      );
      setTitle(response.data);
      console.log(response.data);
    }
    getStoreData();
  }, []);
  return (
    <div className="specie-body">
      <div className="specie-container">
        <div className="specie-title">
          <h1 contenteditable>{specie}</h1>
          <Link to="/" style={{ textDecoration: "none" }}>
            <button class="button-14" role="button">
              Home
            </button>
          </Link>
        </div>
        <div>
          <ul>{finalAnim}</ul>
        </div>
      </div>
    </div>
  );
}

export default Specie;
