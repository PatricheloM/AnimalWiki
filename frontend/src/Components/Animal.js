import React from "react";
import { useEffect, useState } from "react";
import axios from "axios";
import { useParams } from "react-router-dom";
import "../style/Animal.css";

function Animal({ match }) {
  let { animal } = useParams();
  const [Ani, setAnimal] = useState([]);
  useEffect(() => {
    async function getStoreData() {
      const response = await axios.get(
        `http://localhost:8080/api/animal/${animal}`
      );
      setAnimal(response.data);
      console.log(response.data);
    }
    getStoreData();
  }, []);
  return (
    <div className="animal-body">
      <div className="animal-header">
        <h1>{Ani.name}</h1>
      </div>
      <p>
        <img src={Ani.img}></img>
      </p>
      <div class="nest">
        <h3 class="liner">{Ani.type}</h3>
        <h4>{Ani.desc}</h4>
      </div>
    </div>
  );
}

export default Animal;
