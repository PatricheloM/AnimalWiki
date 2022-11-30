import MainPage from "./Components/MainPage";
import Specie from "./Components/Specie";
import Animal from "./Components/Animal";
import { BrowserRouter, Routes, Route, Link } from "react-router-dom";

function App() {
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<MainPage />} />
          <Route path="/:specie" element={<Specie />} />
          <Route path="/animal/:animal" element={<Animal />}></Route>
		  <Route path="*" element={<PageNotFound />} />
        </Routes>
      </BrowserRouter>
    </>
  );
}

function PageNotFound() {
  return (
    <>
		<h1>Page not found</h1>
		<Link to="/" style={{ textDecoration: "none" }}>
            <button class="button-14" role="button">
              Home
            </button>
        </Link>
    </>
  );
}

export default App;
