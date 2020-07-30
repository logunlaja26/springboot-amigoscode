import React from 'react';
import Container from './Container';
import { Button } from 'antd';

const Footer = (props) => (
    <div>
        <Container>
            <Button type='primary'>Add new student +</Button>
        </Container>
    </div>
);

export default Footer;