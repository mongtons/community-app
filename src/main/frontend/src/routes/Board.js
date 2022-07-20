import NavBar from "../components/NavBar";
import { useParams } from "react-router-dom";

function Board() {
  const id = useParams();
  return (
    <>
      <NavBar />
      <div className="container overflow-auto">
        <div className="container mt-5 text-center">
          <h2>
            {id.id === "1" ? "자유 " : id.id === "2" ? "정보 " : "장터 "}
            게시판
          </h2>
        </div>
        <div className="container mt-5">
          <div className="row justify-content-end">
            <div className="col-1">
              <select
                className="form-select form-select-md"
                aria-label=".form-select-sm example"
              >
                <option selected>선택</option>
                <option value="1">제목</option>
                <option value="2">작성자</option>
              </select>
            </div>
            <div className="col-3">
              <form className="d-flex" role="search">
                <input
                  className="form-control me-2"
                  type="search"
                  placeholder="Search"
                  aria-label="Search"
                />
                <button className="btn btn-outline-success" type="submit">
                  Search
                </button>
              </form>
            </div>
          </div>
        </div>
        <table className="table container mt-3">
          <thead>
            <tr className="text-center table-active">
              <th scope="col" className="col-1">
                번호
              </th>
              <th scope="col" className="col-5 ">
                제목
              </th>
              <th scope="col" className="col-2 ">
                작성자
              </th>
              <th scope="col" className="col-2 ">
                작성일
              </th>
              <th scope="col" className="col-2">
                추천수
              </th>
            </tr>
          </thead>
          <tbody></tbody>
        </table>
      </div>
    </>
  );
}

export default Board;
