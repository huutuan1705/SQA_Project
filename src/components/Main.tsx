function Main({ children }: any) {
  return (
    <main id='main' style={{ flex: 1 }}>
      <div className='title'>
        <i style={{ fontSize: 18 }} className='fa fa-gear'></i>
        <span>Đăng kí môn học học kì I - năm học 2024-2025</span>
      </div>
      {children}
    </main>
  );
}

export default Main;
