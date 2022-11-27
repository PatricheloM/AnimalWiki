import React from "react";
// import { useEffect, useState } from "react";
// import axios from "axios";

function SearchBar({ placeholder }) {
  // const [anim, setAnim] = useState([]);
  // useEffect(() => {
  //   async function getAnimals() {
  //     const getback = await axios.get("http://localhost:8080/api/animal");
  //     setAnim(getback.data);
  //   }
  //   getAnimals();
  // }, []);
  return (
    <div className="search">
      <div className="searchInputs">
        <input type="text" placeholder={placeholder} />
        <div className="searchIcon"></div>
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
