import React from "react";
import { useEffect, useState } from "react";
import axios from "axios";
import { useParams, Link } from "react-router-dom";
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
    }
    getStoreData();
  }, []);
  return (
    <div className="animal-body">
      <div className="animal-header">
        <h1>{Ani.name}</h1>
		   <Link to="/" style={{ textDecoration: "none" }}>
            <button class="button-14" role="button">
              Home
            </button>
          </Link>
      </div>
      <img src={Ani.img} />
      <div class="nest">
        <h3 class="liner">{"TYPE: " + Ani.type}</h3>
		<h3 class="liner">{Ani.extinct ? "EXTINCT: YES" : "EXTINCT: NO"}</h3>
        <h4>{Ani.desc}</h4>
      </div>
    </div>
  );
}

export default Animal;
