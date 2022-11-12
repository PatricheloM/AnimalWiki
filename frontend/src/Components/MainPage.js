import logo from "../Logo/logo-no-background.png";
import "../style/MainPage.css";
import axios from "axios";
import { useEffect, useState } from "react";

export default function MainPage() {
  let itemList = [];
  const [title, setTitle] = useState([]);
  title.forEach((item, index) => {
    itemList.push(<li key={index}>{item}</li>);
  });
  useEffect(() => {
    async function getStoreData() {
      const response = await axios.get("http://localhost:8080/api/type");
      setTitle(response.data);
    }
    getStoreData();
  }, []);
  return (
    <div className="container">
      <div className="firstLine">
        <img src={logo} alt="Logo" /> <ul className="firstUl">{itemList}</ul>
      </div>
      <div className="secondLine">
        <div className="search__container">
          <input className="search__input" type="text" placeholder="Search" />
        </div>
      </div>
    </div>
  );
}
