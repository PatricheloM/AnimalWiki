import React from "react";
import { useEffect, useState } from "react";
import axios from "axios";

function SearchBar({ placeholder }) {
  // const [anim, setAnim] = useState([]);
  // useEffect(() => {
  //   async function getAnimals() {
  //     const getback = await axios.get("http://localhost:8080/api/animal");
  //     setAnim(getback.data);
  //   }
  //   getAnimals();
  // }, []);
  const [value, setValue] = useState([]);
  const [res, setRes] = useState([]);
  useEffect(() => {
    async function getStoreData() {
      const response = await axios.get(
        `http://localhost:8080/api/query/${value}`
      );
      setRes(response.data);
    }
    getStoreData();
  }, [value]);

  let final = [];
  res.forEach((element) => final.push(<li>{element}</li>));
  if (!res) {
    console.log("Array is empty!");
    console.log("inside res" + res);
    final = [];
  }
  console.log(final);
  return (
    <div className="search">
      <div className="searchInputs">
        <input
          type="text"
          placeholder="hello"
          onChange={(e) => setValue(e.target.value)}
        />
        <div className="searchResult">{final}</div>
      </div>
      <div className="dataResult">
        {/* {anim.map((value) => {
          return <div> {value.name} </div>;
        })} */}
      </div>
    </div>
  );
}

export default SearchBar;
