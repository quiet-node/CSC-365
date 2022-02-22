import * as React from 'react';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';
import { IallBs } from '../types/interfaces';

interface Props {
  rows: Array<IallBs>;
}

export default function BusinessTable({ rows }: Props): JSX.Element {
  return (
    <Paper>
      <Table className='w-full'>
        <TableHead>
          <TableRow>
            <TableCell align='center' width='50px'>
              Similarity Rate
            </TableCell>
            <TableCell align='center' width='200px'>
              Business Name
            </TableCell>
            <TableCell align='center' width='350px'>
              Categories
            </TableCell>
            <TableCell align='center' width='50px'>
              Reviews
            </TableCell>
            <TableCell align='center' width='50px'>
              Stars
            </TableCell>
            <TableCell align='center' width='200px'>
              Address
            </TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {/* {rows.map((row) => ( */}
          {/* <TableRow key={row.id}> */}
          <TableRow>
            <TableCell align='center'>50.78 %</TableCell>

            <TableCell align='center'>Gastropubs</TableCell>
            <TableCell align='left'>cell 2</TableCell>
            <TableCell align='center'>cell4</TableCell>
            <TableCell align='center'>cell4</TableCell>
            <TableCell align='center'>cell4</TableCell>
          </TableRow>
          {/* <TableRow>
            <TableCell align='center' width='120px'>
              cell1
            </TableCell>
            <TableCell align='center'>cell2</TableCell>
            <TableCell align='center'>cell3</TableCell>
            <TableCell align='center'>cell4</TableCell>
            <TableCell align='center'>cell4</TableCell>
            <TableCell align='center'>cell4</TableCell>
          </TableRow> */}
          {/* ))} */}
        </TableBody>
      </Table>
    </Paper>
  );
}
