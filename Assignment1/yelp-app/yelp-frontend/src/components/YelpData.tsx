import { useState } from 'react';
import axios from 'axios';

const YelpData = () => {
  const [businessName, setBusinessName] = useState('');

  const getData = async (): Promise<void> => {
    const res = await axios.get(
      `http://localhost:8080/yelpdata/${businessName}`
    );

    console.log(res.data);
    console.log(businessName);
  };

  return (
    <div className='bg-violet-200 min-h-screen w-full flex justify-center'>
      <div className='flex justify-center items-center'>
        <input
          type='text'
          className='mr-5 border-[1px] border-green-400'
          placeholder='Business Name...'
          name='businessName'
          value={businessName}
          onChange={(e) => setBusinessName(e.target.value)}
        />

        <button
          className='bg-blue-500 py-2 px-5 border-2 rounded-lg  '
          onClick={getData}
        >
          {' '}
          Get Data{' '}
        </button>
      </div>
    </div>
  );
};

export default YelpData;
