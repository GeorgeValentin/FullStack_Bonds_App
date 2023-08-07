import { Fragment, useState, useEffect} from 'react';
import { findMaturityBonds } from '../../../services/BondServices';


const SomeOtherPage = () => {
  const [maturityBonds, setMaturityBonds] = useState([]);

  useEffect(() => {
    const getMaturityBonds = async () => {
      try {
        const res = await findMaturityBonds(1);
        setMaturityBonds(res.data);
      } catch (err) {
        console.log(`The error ${err} occured when fetching the bonds`);
      }
    };

    getMaturityBonds();
  }, []);
  console.log(maturityBonds)
  if (maturityBonds===null){
    return <div>Loading...</div>
  }
 console.log(maturityBonds)
  return (
    <Fragment>
      <div>Some Other Page here!</div>
      <div>These are bonds that reach maturity:</div>
      {maturityBonds.map((maturityBond, index)=> {
        return(
          <div>
            <div>bond ID:</div>
        <div>{maturityBond.bondId}</div>,
        <div>{maturityBond.cusip}</div>,
        <div>{maturityBond.isin}</div>,
        <div>{maturityBond.issuerName}</div>,
        <div>{maturityBond.clientName}</div>
        </div>
        )
      }
        
      )}
    </Fragment>
  );
};

export default SomeOtherPage;
