import { memo, useCallback, useContext } from 'react';
import { DataContext } from './context/DataContext/Data.context';
import { toast } from 'react-toastify';

function RegistedDataTable() {
  const {
    registerOfStudent,
    handleDeleteSectionClass,
    subjectSemesterSchoolYearForm,
  } = useContext(DataContext);
  const handleDeselect = useCallback(
    async (idSectionClass: number) => {
      if (window.confirm('Bạn có muốn bỏ đăng kí lớp học phần này không?')) {
        const isSuccess = await handleDeleteSectionClass({
          idSectionClass,
          idStudentDepartment:
            subjectSemesterSchoolYearForm.idStudentDepartment,
        });
        if (isSuccess) {
          toast.info('Bỏ đăng kí môn học thành công.');
        } else {
          toast.error('Bỏ đăng kí môn học thất bại.');
        }
      }
    },
    [subjectSemesterSchoolYearForm]
  );
  return (
    <div style={{ maxWidth: 600 }}>
      <div className='description'>
        <h3>Danh sách môn học đã đăng ký</h3>
      </div>
      <table className='data-table'>
        <thead>
          <tr>
            <th className='subject-param-id'>Mã MH</th>
            <th className='subject-param-name'>Tên môn học</th>
            <th>Nhóm</th>
            <th>Số TC</th>
            {/* <th></th> */}
          </tr>
        </thead>
        <tbody>
          {registerOfStudent.map((subjectSemesterSchoolYear, i) => (
            <tr key={i}>
              <td style={{ textAlign: 'center' }}>
                {
                  subjectSemesterSchoolYear.sectionClass.subjectSemester.subject
                    .id
                }
              </td>
              <td>
                {
                  subjectSemesterSchoolYear.sectionClass.subjectSemester.subject
                    .name
                }
              </td>
              <td style={{ textAlign: 'center' }}>
                {subjectSemesterSchoolYear.sectionClass.name}
              </td>
              <td style={{ textAlign: 'center' }}>
                {
                  subjectSemesterSchoolYear.sectionClass.subjectSemester.subject
                    .credit
                }
              </td>
              {/* <td style={{ textAlign: 'center' }}>
                <button
                  className='cursor-pointer'
                  onClick={() =>
                    handleDeselect(subjectSemesterSchoolYear.sectionClass.id)
                  }
                >
                  Xóa
                </button>
              </td> */}
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default memo(RegistedDataTable);
