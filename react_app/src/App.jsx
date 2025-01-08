import React, { useEffect, useState } from "react";

function App() {
  const [message, setMessage] = useState("");

  useEffect(() => {
    fetch("http://localhost:8080/api/message") // Spring Boot API 호출
      .then((response) => response.text()) // 응답을 텍스트로 받음
      .then((data) => setMessage(data)); // 상태에 데이터 저장
  }, []);

  return (
    <div>
      <h1>{message}</h1> {/* API에서 받은 메시지 출력 */}
    </div>
  );
}

export default App;
