import axios from 'axios';
import { IallBs } from '../types/interfaces';
import BusinessTable from '../table/BusinessTable';

interface IProps {
  allBs: Array<IallBs>;
}

const BusinessList = ({ allBs }: IProps): JSX.Element => {
  return (
    <div className=' '>
      <BusinessTable rows={allBs} />
    </div>
  );
};

export default BusinessList;
