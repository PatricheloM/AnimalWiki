import logo from "../Logo/logo-no-background.png";
import "../style/MainPage.css";
import axios from "axios";
import { useEffect, useState } from "react";
import SearchBar from "./SearchBar";
import { Link } from "react-router-dom";
import GSearch from "./GSearch";

export default function MainPage() {
  let itemList = [];
  const [title, setTitle] = useState([]);
  title.forEach((item, index) => {
    itemList.push({ item, index });
  });
  useEffect(() => {
    async function getStoreData() {
      const response = await axios.get("http://localhost:8080/api/type");
      setTitle(response.data);
    }
    getStoreData();
  }, []);
  console.log(itemList);

  return (
    <div className="container">
      <div className="firstLine">
        <img src={logo} alt="Logo" />
        {/* <ul className="firstUl">{itemList}</ul> */}
        {
          <ul className="firstUl">
            {itemList.map((value) => (
              <Link to={value.item}>{value.item}</Link>
            ))}
          </ul>
        }
      </div>
      <div className="secondLine">
        <div className="search__container">
          <GSearch />
        </div>
      </div>
    </div>
  );
}
