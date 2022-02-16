import axios from 'axios';

const getData = async (): Promise<void> => {
  const res = await axios.get('http://localhost:8080/yelpdata');
  console.log(res);
};

const YelpData = () => {
  return (
    <div className='bg-violet-200 min-h-screen w-full flex justify-center'>
      <div className='flex justify-center items-center'>
        <button
          className='bg-blue-500 py-2 px-5 border-2 rounded-lg  '
          onClick={getData}
        >
          {' '}
          click{' '}
        </button>
      </div>
    </div>
  );
};

export default YelpData;
