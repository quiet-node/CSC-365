import { useState } from 'react';
import axios from 'axios';
import SearchIcon from '@material-ui/icons/Search';

const YelpData = () => {
  const [businessName, setBusinessName] = useState('');

  const getSimilarBusinesses = async (e: any): Promise<void> => {
    e.preventDefault();
    const res = await axios.get(
      `http://localhost:8080/yelpdata/similar/${businessName}`
    );
    setBusinessName('');
    console.log('res.data');
  };

  const getAllBusinesses = async (): Promise<void> => {
    const res = await axios.get('http://localhost:8080/yelpdata/allBusinesses');

    console.log('res.data');
  };

  return (
    <div className=' bg-slate-200 min-h-screen w-full flex justify-center'>
      <div className='flex w-full justify-center flex-col items-center'>
        <div>Header</div>
        <div className='flex h-4/6 w-full'>
          <form
            onSubmit={getSimilarBusinesses}
            className=' flex ml-20 items-center'
          >
            <SearchIcon className='absolute mx-2 text-slate-400' />
            <input
              type='text'
              className='py-[7px] pl-10 border-[1px] shadow-lg rounded-md outline-0 text-gray-400'
              placeholder='Business Name...'
              name='businessName'
              value={businessName}
              onChange={(e) => setBusinessName(e.target.value)}
            />
            <button type='submit'></button>
          </form>

          <div className='flex justify-center items-center w-3/5'>
            Business List{' '}
          </div>
        </div>
      </div>
    </div>
  );
};

export default YelpData;
