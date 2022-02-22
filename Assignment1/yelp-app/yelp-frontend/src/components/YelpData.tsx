import { useEffect, useState } from 'react';
import axios from 'axios';
import SearchIcon from '@material-ui/icons/Search';
import Header from './Header';
import BusinessList from './BusinessList';
import { IallBs } from '../types/interfaces';

const YelpData = () => {
  let allBs: Array<IallBs> = [];

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

  const getAllBs = async () => {
    const res = await axios.get('http://localhost:8080/yelpdata/allbusinesses');

    res.data.map((data: any) => {
      allBs.push(data);
    });
  };

  useEffect(() => {
    getAllBs();
  }, []);

  return (
    <div className=' bg-slate-200 min-h-screen w-full flex justify-center'>
      <div className='flex w-full justify-center flex-col items-center'>
        <div className='flex justify-center items-center w-full  h-36 mb-8'>
          <Header />
        </div>
        <div className='flex justify-center items-center w-full h-20 '>
          <div className='bg-white h-32 flex justify-center items-center w-[750px] rounded-lg drop-shadow-2xl'>
            <form
              onSubmit={getSimilarBusinesses}
              className=' flex ml-20 items-center'
            >
              <SearchIcon className='absolute mx-2 text-slate-400' />
              <input
                type='text'
                className='py-[7px] pl-24 pr-48 border-[1px] shadow-lg rounded-md outline-0 text-gray-400'
                placeholder='Business Name...'
                name='businessName'
                value={businessName}
                onChange={(e) => setBusinessName(e.target.value)}
              />
              <button
                type='submit'
                className='cursor-pointer bg-indigo-500 px-10 ml-5 shadow-2xl rounded-full py-2 font-bold text-white hover:bg-indigo-600 '
              >
                Find
              </button>
            </form>
          </div>
        </div>
        <div className='flex justify-center  w-full my-10 py-10'>
          <BusinessList allBs={allBs} />
        </div>
      </div>
    </div>
  );
};

export default YelpData;
